package br.com.fiap.b3_challenge_backend.dao;

import jakarta.ws.rs.NotFoundException;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DAO<T> {
    public final Connection connection;
    public final String tableName;
    public final String idColumn;
    public final Map<String, String> columnAttrMap;
    public final Class<T> clazz;

    DAO(Connection connection, String tableName, String idColumn, Map<String, String> columnAttrMap, Class<T> clazz) {
        this.connection = connection;
        this.tableName = tableName;
        this.idColumn = idColumn;
        this.columnAttrMap = columnAttrMap;
        this.clazz = clazz;
    }

    public static String pascalCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public Object getAttrFromEntity(T obj, String methodName) throws Exception {
        Method method = clazz.getMethod(methodName);
        return method.invoke(obj);
    }

    public void setAttrFromEntity(String methodName, Class valueClass, Object value, T obj) throws Exception {
        Method method = clazz.getMethod(methodName, valueClass);
        method.invoke(obj, value);
    }

    public Class getAttrClass(String attrName) throws Exception {
        Method method = clazz.getMethod("get" + attrName);
        return method.getReturnType();
    }

    public void setAllFields(PreparedStatement ps, T entity) throws Exception {
        int i = 0;
        for (String column : this.columnAttrMap.keySet()) {
            String attr = this.columnAttrMap.get(column);
            Object attrValue = getAttrFromEntity(entity, "get" + attr);
            Class attrClass = getAttrClass(attr);

            if (attrClass.equals(String.class)) {
                ps.setString(++i, (String) attrValue);
            } else if (attrClass.equals(Integer.class)) {
                ps.setInt(++i, (Integer) attrValue);
            }
        }
    }

    public T createFromResult(ResultSet rs) throws Exception {
        T obj = clazz.getConstructor().newInstance();

        for (String column : this.columnAttrMap.keySet()) {
            String attr = this.columnAttrMap.get(column);
            setAttrFromEntity("set" + attr, getAttrClass(attr), rs.getString(column), obj);
        }

        setAttrFromEntity("set" + pascalCase(idColumn), Integer.class, rs.getInt(idColumn), obj);

        return obj;
    }

    public String getCreateSQL() {
        String columns = String.join(", ", columnAttrMap.keySet());
        String values = String.join(", ", Collections.nCopies(columnAttrMap.size(), "?"));

        return String.format("INSERT INTO %s (%s) VALUES (%s)", this.tableName, columns, values);
    }

    public String getSingleSelectSQL() {
        return String.format("SELECT * FROM %s WHERE %s = ?", tableName, idColumn);
    }

    public String getAllSelectSQL() {
        return String.format("SELECT * FROM %s", tableName);
    }

    public String getUpdateSQL() {
        String values = String.join(", ", Collections.nCopies(columnAttrMap.size(), "%s = ?"));
        return String.format(String.format("UPDATE %s SET %s WHERE %s = ?", tableName, values, idColumn), columnAttrMap.keySet().toArray());
    }

    public String getDeleteSQL() {
        return String.format("DELETE FROM %s WHERE %s = ?", tableName, idColumn);
    }

    public T create(T entity) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String[] returnId = {this.idColumn};
            ps = connection.prepareStatement(getCreateSQL(), returnId);
            setAllFields(ps, entity);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                setAttrFromEntity("set" + pascalCase(this.idColumn), Integer.class, rs.getInt(1), entity);
            }

            return entity;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    public T get(int id) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(getSingleSelectSQL());
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return createFromResult(rs);
            }

            throw new NotFoundException(String.format("%s ID %d not found.", clazz.getSimpleName(), id));
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    public List<T> get() throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(getAllSelectSQL())) {
            List<T> entityList = new ArrayList<>();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                entityList.add(createFromResult(rs));
            }

            return entityList;
        }
    }

    public void update(int id, T entity) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(getUpdateSQL())) {
            setAllFields(ps, entity);
            ps.setInt(this.columnAttrMap.size() + 1, id);
            int rowAffected = ps.executeUpdate();

            if (rowAffected == 0) {
                throw new NotFoundException(String.format("%s ID %d not found.", clazz.getSimpleName(), id));
            }
        }
    }

    public void delete(int id) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(getDeleteSQL())) {
            ps.setInt(1, id);
            int rowAffected = ps.executeUpdate();

            if (rowAffected == 0) {
                throw new NotFoundException(String.format("%s ID %d not found.", clazz.getSimpleName(), id));
            }
        }
    }
}
