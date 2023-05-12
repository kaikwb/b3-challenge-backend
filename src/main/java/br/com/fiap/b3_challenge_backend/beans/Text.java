package br.com.fiap.b3_challenge_backend.beans;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDateTime;

public class Text {
    private Integer id;
    private String title;
    private String author;
    private String source;
    private String link;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    private String content;

    /**
     * Cria uma materia sem dados.
     */
    public Text() {
    }

    /**
     * Cria uma materia com dados.
     *
     * @param id        identificador da materia.
     * @param title     título da materia.
     * @param author    autor da materia.
     * @param source    fonte da materia.
     * @param link      link da materia.
     * @param createdAt data de criação da materia.
     * @param content   conteúdo da materia.
     */
    public Text(Integer id, String title, String author, String source, String link, LocalDateTime createdAt, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.source = source;
        this.link = link;
        this.createdAt = createdAt;
        this.content = content;
    }

    /**
     * Retorna o identificador da materia.
     *
     * @return identificador da materia.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador da materia.
     *
     * @param id identificador da materia.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o título da materia.
     *
     * @return título da materia.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título da materia.
     *
     * @param title título da materia.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o autor da materia.
     *
     * @return autor da materia.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Define o autor da materia.
     *
     * @param author autor da materia.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Retorna a fonte da materia.
     *
     * @return fonte da materia.
     */
    public String getSource() {
        return source;
    }

    /**
     * Define a fonte da materia.
     *
     * @param source fonte da materia.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Retorna o link da materia.
     *
     * @return link da materia.
     */
    public String getLink() {
        return link;
    }

    /**
     * Define o link da materia.
     *
     * @param link link da materia.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Retorna a data de criação da materia.
     *
     * @return data de criação da materia.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Define a data de criação da materia.
     *
     * @param createdAt data de criação da materia.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Retorna o conteúdo da materia.
     *
     * @return conteúdo da materia.
     */
    public String getContent() {
        return content;
    }

    /**
     * Define o conteúdo da materia.
     *
     * @param content conteúdo da materia.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
