package br.com.fiap.b3_challenge_backend.beans;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDateTime;

public class Article {
    private Integer id;
    private String title;
    private String author;
    private String source;
    private String link;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    private String content;

    /**
     * Cria um artigo sem dados.
     */
    public Article() {
    }

    /**
     * Cria um artigo com dados.
     *
     * @param id        identificador da materia.
     * @param title     título da materia.
     * @param author    autor da materia.
     * @param source    fonte da materia.
     * @param link      link da materia.
     * @param createdAt data de criação da materia.
     * @param content   conteúdo da materia.
     */
    public Article(Integer id, String title, String author, String source, String link, LocalDateTime createdAt, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.source = source;
        this.link = link;
        this.createdAt = createdAt;
        this.content = content;
    }

    /**
     * Retorna o identificador do artigo.
     *
     * @return identificador do artigo.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador do artigo.
     *
     * @param id identificador do artigo.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o título do artigo.
     *
     * @return título do artigo.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título do artigo.
     *
     * @param title título do artigo.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o autor do artigo.
     *
     * @return autor do artigo.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Define o autor do artigo.
     *
     * @param author autor do artigo.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Retorna a fonte do artigo.
     *
     * @return fonte do artigo.
     */
    public String getSource() {
        return source;
    }

    /**
     * Define a fonte do artigo.
     *
     * @param source fonte do artigo.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Retorna o link do artigo.
     *
     * @return link do artigo.
     */
    public String getLink() {
        return link;
    }

    /**
     * Define o link do artigo.
     *
     * @param link link do artigo.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Retorna a data de criação do artigo.
     *
     * @return data de criação do artigo.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Define a data de criação do artigo.
     *
     * @param createdAt data de criação do artigo.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Retorna o conteúdo do artigo.
     *
     * @return conteúdo do artigo.
     */
    public String getContent() {
        return content;
    }

    /**
     * Define o conteúdo do artigo.
     *
     * @param content conteúdo do artigo.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
