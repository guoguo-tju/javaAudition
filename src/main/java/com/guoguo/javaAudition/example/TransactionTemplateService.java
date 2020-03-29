package com.guoguo.javaAudition.example;

import java.util.concurrent.Callable;

public interface TransactionTemplateService {

    <T> T tx(Callable<T> c);

}
