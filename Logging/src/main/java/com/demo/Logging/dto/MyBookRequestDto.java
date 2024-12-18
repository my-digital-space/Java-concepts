package com.demo.Logging.dto;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class MyBookRequestDto implements Serializable {

    @NotNull(message = "Book name is required")
    private String bookName;

    @NotNull(message = "Book author is required")
    private String bookAuthor;

}
