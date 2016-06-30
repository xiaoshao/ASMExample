package com;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.io.*;

/**
 * Created by zwshao on 6/29/16.
 */
public class ClassWriterMain {

    public static void main(String[] args) throws IOException {
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE,
                "Comparable", null, "java/lang/Object", new String[]{"com/asm3/Mesurable"});

        classWriter.visitEnd();

        classWriter.visitField(Opcodes.ACC_PRIVATE + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC,
                "LESS", "I", "kkkkk", new Integer(-1)).visitEnd();

        byte[] bytes = classWriter.toByteArray();


        FileOutputStream outputStream = new FileOutputStream(new File("test.class"));
        outputStream.write(bytes);
        outputStream.close();
    }
}
