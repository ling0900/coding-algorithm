package com.base.agent;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

class MyTransformer implements ClassFileTransformer {
    public static void main(String[] args) {

    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (className.equals("com/example/MyClass")) {
            // Modify the bytecode of MyClass if needed
            System.out.println("Transforming " + className);
            // Return modified bytecode or the original bytecode
        }
        return classfileBuffer;
    }
}
