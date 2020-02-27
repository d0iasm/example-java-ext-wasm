package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;

import org.wasmer.Module;
import org.wasmer.Instance;
import org.wasmer.Memory;

class MemoryExample {
    public static void main(String[] args) throws IOException {
		Path wasmPath = Paths.get(new MemoryExample().getClass().getClassLoader().getResource("memory.wasm").getPath());
        // Reads the WebAssembly module as bytes.
        byte[] wasmBytes = Files.readAllBytes(wasmPath);

        // Compiles the bytes into a WebAssembly module.
        Module module = new Module(wasmBytes);

        // Instantiates the WebAssembly module.
        // This is another way to create an instance object.
        Instance instance = module.instantiate();

        // Gets the memory by specifing its exported name.
        Memory memory = instance.memories.get("memory");

        // Gets the pointer value as an integer.
        int pointer = (Integer) instance.exports.get("return_hello").apply()[0];

        // Reads the data from the memory.
        byte[] stringBytes = memory.read(pointer, 13);

        System.out.println(new String(stringBytes)); // Hello, World!

        instance.close();
    }
}
