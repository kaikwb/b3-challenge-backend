package br.com.fiap.b3_challenge_backend.beans;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDateTime;

public class Video {
    private Integer id;
    private String title;
    private String author;
    private String source;
    private String link;
    private String videoId;
    private String thumbnail;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * Cria um video sem dados.
     */
    public Video() {
    }

    /**
     * Cria um video com dados.
     *
     * @param id        identificador do video.
     * @param title     título do video.
     * @param author    autor do video.
     * @param source    fonte do video.
     * @param link      link do video.
     * @param videoId   id do video.
     * @param thumbnail thumbnail do video.
     * @param createdAt data de criação do video.
     */
    public Video(Integer id, String title, String author, String source, String link, String videoId, String thumbnail, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.source = source;
        this.link = link;
        this.videoId = videoId;
        this.thumbnail = thumbnail;
        this.createdAt = createdAt;
    }

    /**
     * Retorna o identificador do video.
     *
     * @return identificador do video.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador do video.
     *
     * @param id identificador do video.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o título do video.
     *
     * @return título do video.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título do video.
     *
     * @param title título do video.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o autor do video.
     *
     * @return autor do video.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Define o autor do video.
     *
     * @param author autor do video.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Retorna a fonte do video.
     *
     * @return fonte do video.
     */
    public String getSource() {
        return source;
    }

    /**
     * Define a fonte do video.
     *
     * @param source fonte do video.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Retorna o link do video.
     *
     * @return link do video.
     */
    public String getLink() {
        return link;
    }

    /**
     * Define o link do video.
     *
     * @param link link do video.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Retorna o id do video.
     *
     * @return id do video.
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * Define o id do video.
     *
     * @param videoId id do video.
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    /**
     * Retorna o thumbnail do video.
     *
     * @return thumbnail do video.
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Define o thumbnail do video.
     *
     * @param thumbnail thumbnail do video.
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * Retorna a data de criação do video.
     *
     * @return data de criação do video.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Define a data de criação do video.
     *
     * @param createdAt data de criação do video.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
