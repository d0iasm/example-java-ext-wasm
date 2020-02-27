(module
  (type $t0 (func (result i32)))
  (func $return_hello (export "return_hello") (type $t0) (result i32)
    i32.const 1024)
  (table $T0 1 1 anyfunc)
  (memory $memory (export "memory") 17)
  (data (i32.const 1024) "Hello, World!\00"))
