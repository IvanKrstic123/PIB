package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Type;
import java.util.List;

public interface TypeService {

    public Type saveType(Type type);

    public List<Type> getTypes();
}
