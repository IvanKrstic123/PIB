package com.bezkoder.springjwt.services.implementation;

import com.bezkoder.springjwt.models.Type;
import com.bezkoder.springjwt.repository.TypeRepository;
import com.bezkoder.springjwt.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl  implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public List<Type> getTypes() {
        return typeRepository.findAll();
    }
}
