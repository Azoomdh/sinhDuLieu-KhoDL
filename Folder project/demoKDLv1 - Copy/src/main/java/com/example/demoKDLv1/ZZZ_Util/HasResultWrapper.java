package com.example.demoKDLv1.ZZZ_Util;

import java.util.Collection;
import java.util.List;

public interface HasResultWrapper<T> {

    public T resultWrapper(T object1);

    public List<T> resultWrapper(List<T> listObject1);

}
