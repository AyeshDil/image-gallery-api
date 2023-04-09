package com.imagegallery.imagegalleryapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "image_table")
public class Image {

    @Id
    @Column(name = "image_id", length = 50)
    private String imageID;

    @Column(name = "caption", length = 50)
    private String caption;

    @Column(name = "tags", length = 50)
    private String tags;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;
}
