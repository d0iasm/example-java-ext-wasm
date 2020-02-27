# example-java-ext-wasm
An example project for [java-ext-wasm](https://github.com/wasmerio/java-ext-wasm).

## Build and execute
```sh
// Install a Wasmer plugin to our project.
$ mvn install:install-file -Dfile=wasmer-0.1.jar

// Compile java source files.
$ mvn compile

// Execute our project with the library path.
$ MAVEN_OPTS=-Djava.library.path=. mvn exec:java
```

## Compile a Rust file to WebAssembly
```sh
$ rustup target add wasm32-unknown-unknown
$ rustc --target wasm32-unknown-unknown simple.rs --crate-type cdylib
```
