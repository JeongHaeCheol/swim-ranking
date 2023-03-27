package com.example.swimranking.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.swimranking.dto.QSwimmerDto is a Querydsl Projection type for SwimmerDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QSwimmerDto extends ConstructorExpression<SwimmerDto> {

    private static final long serialVersionUID = -1025801843L;

    public QSwimmerDto(com.querydsl.core.types.Expression<? extends com.example.swimranking.model.Swimmer> swimmer) {
        super(SwimmerDto.class, new Class<?>[]{com.example.swimranking.model.Swimmer.class}, swimmer);
    }

}

