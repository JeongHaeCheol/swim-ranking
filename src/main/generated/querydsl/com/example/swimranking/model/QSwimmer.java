package com.example.swimranking.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSwimmer is a Querydsl query type for Swimmer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSwimmer extends EntityPathBase<Swimmer> {

    private static final long serialVersionUID = -1746722180L;

    public static final QSwimmer swimmer = new QSwimmer("swimmer");

    public final DateTimePath<java.util.Date> birth = createDateTime("birth", java.util.Date.class);

    public final StringPath club = createString("club");

    public final StringPath country = createString("country");

    public final StringPath gender = createString("gender");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QSwimmer(String variable) {
        super(Swimmer.class, forVariable(variable));
    }

    public QSwimmer(Path<? extends Swimmer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSwimmer(PathMetadata metadata) {
        super(Swimmer.class, metadata);
    }

}

