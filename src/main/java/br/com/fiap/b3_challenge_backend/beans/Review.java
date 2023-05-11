package br.com.fiap.b3_challenge_backend.beans;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDateTime;

public class Review {
    private Integer id;
    private String title;
    private String author;
    private String company;
    private String source;
    private String link;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    private String content;

    /**
     * Cria uma review sem dados.
     */
    public Review() {
    }

    /**
     * Cria uma review com dados.
     *
     * @param id        identificador da review.
     * @param title     título da review.
     * @param author    autor da review.
     * @param company   empresa da review.
     * @param source    fonte da review.
     * @param link      link da review.
     * @param createdAt data de criação da review.
     * @param content   conteúdo da review.
     */
    public Review(Integer id, String title, String author, String company, String source, String link, LocalDateTime createdAt, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.company = company;
        this.source = source;
        this.link = link;
        this.createdAt = createdAt;
        this.content = content;
    }

    /**
     * Retorna o identificador da review.
     *
     * @return identificador da review.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador da review.
     *
     * @param id identificador da review.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o título da review.
     *
     * @return título da review.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título da review.
     *
     * @param title título da review.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o autor da review.
     *
     * @return autor da review.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Define o autor da review.
     *
     * @param author autor da review.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Retorna a empresa da review.
     *
     * @return empresa da review.
     */
    public String getCompany() {
        return company;
    }

    /**
     * Define a empresa da review.
     *
     * @param company empresa da review.
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Retorna a fonte da review.
     *
     * @return fonte da review.
     */
    public String getSource() {
        return source;
    }

    /**
     * Define a fonte da review.
     *
     * @param source fonte da review.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Retorna o link da review.
     *
     * @return link da review.
     */
    public String getLink() {
        return link;
    }

    /**
     * Define o link da review.
     *
     * @param link link da review.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Retorna a data de criação da review.
     *
     * @return data de criação da review.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Define a data de criação da review.
     *
     * @param createdAt data de criação da review.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Retorna o conteúdo da review.
     *
     * @return conteúdo da review.
     */
    public String getContent() {
        return content;
    }

    /**
     * Define o conteúdo da review.
     *
     * @param content conteúdo da review.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
