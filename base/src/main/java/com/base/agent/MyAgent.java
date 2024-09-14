package com.base.agent;

import java.lang.instrument.Instrumentation;

public class MyAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Agent initialized");
        inst.addTransformer(new MyTransformer());
    }


}

