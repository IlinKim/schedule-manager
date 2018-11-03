package com.ilsee.schedulemanager.domain.support.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelUtils {

    private static final ModelMapper mapper = new ModelMapper();

    public static <T> T convert(Object source, Class<T> destinationType) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationType);
    }

    public static <T> List<T> convert(List<?> source, Class<T> destinationType) {
        return source.stream().map(o -> convert(o, destinationType)).collect(Collectors.toList());
    }

    public static <T> Set<T> convert(Set<?> source, Class<T> destinationType) {
        return source.stream().map(o -> convert(o, destinationType)).collect(Collectors.toSet());
    }

    public static <T> Page<T> convert(Page<?> source, Class<T> destinationType) {
        return source.map(o -> convert(o, destinationType));
    }
}
