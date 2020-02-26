package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;

import org.wasmer.Instance;

class Main {
    public static void main(String[] args) throws IOException {
        Path wasmPath = Paths.get(new Main().getClass().getClassLoader().getResource("simple.wasm").getPath());
        // Reads the WebAssembly module as bytes.
        byte[] wasmBytes = Files.readAllBytes(wasmPath);

        // Instantiates the WebAssembly module.
        Instance instance = new Instance(wasmBytes);

        // Calls that exported function, and returns an object array.
        Object[] results = instance.exports.get("sum").apply(5, 37);

        System.out.println((Integer) results[0]); // 42

        instance.close();
    }
}

