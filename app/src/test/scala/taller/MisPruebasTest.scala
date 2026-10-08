package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner



@RunWith(classOf[JUnitRunner])
class MisPruebasTest extends AnyFunSuite {

  val c = new CifradosClasicos()
  import c._

  // Punto 1: cesar

  test("cesar: xyz con 3 da abc") {

    assert(cesar("xyz", 3) == "abc")

  }

  test("cesar: abc con -1 da zab") {

    assert(cesar("abc", -1) == "zab")

  }

  test("cesar: 52 son dos vueltas completas y no cambia nada") {

    assert(cesar("abc", 52) == "abc")

  }

  test("cesar: la coma y el signo de exclamación no cambian") {

    assert(cesar("hola, mundo!", 1) == "ipmb, nvoep!")

  }

  test("cesar: zebra con 1 da afcsb") {

    assert(cesar("zebra", 1) == "afcsb")

  }

  // Punto 2: cesarCola

  test("cesarCola: xyz con 3 da abc") {

    assert(cesarCola("xyz", 3) == "abc")

  }

  test("cesarCola: -27 es lo mismo que -1") {

    assert(cesarCola("abc", -27) == "zab")

  }

  test("cesarCola: el mensaje vacío sale vacío") {

    assert(cesarCola("", 7) == "")

  }

  test("cesarCola: los dígitos y los espacios no cambian") {

    assert(cesarCola("a1 b2", 2) == "c1 d2")

  }

  test("cesarCola: con 26 el mensaje queda igual") {

    assert(cesarCola("abc", 26) == "abc")

  }

  // Punto 3: frecuencias

  test("frecuencias: banana") {

    assert(frecuencias("banana") == List(('a', 3), ('n', 2), ('b', 1)))

  }

  test("frecuencias: si y y z empatan, va primero la y") {

    assert(frecuencias("zzyyx") == List(('y', 2), ('z', 2), ('x', 1)))

  }

  test("frecuencias: las mayúsculas no se cuentan") {

    assert(frecuencias("Aa") == List(('a', 1)))

  }

  test("frecuencias: el espacio no se cuenta") {

    assert(frecuencias("a b a") == List(('a', 2), ('b', 1)))

  }

  test("frecuencias: mississippi") {

    assert(frecuencias("mississippi") == List(('i', 4), ('s', 4), ('p', 2), ('m', 1)))

  }

  // Punto 4: desplazamientoProbable y romperCesar

  test("desplazamientoProbable: si la más frecuente es e da 0") {

    assert(desplazamientoProbable("eee") == 0)

  }

  test("desplazamientoProbable: zzz da 21") {

    assert(desplazamientoProbable("zzz") == 21)

  }

  test("desplazamientoProbable: en abc empatan y gana la a, da 22") {

    assert(desplazamientoProbable("abc") == 22)

  }

  test("desplazamientoProbable: el mensaje vacío da 0") {

    assert(desplazamientoProbable("") == 0)

  }

  test("desplazamientoProbable: ee y ff empatan y gana la e, da 0") {

    assert(desplazamientoProbable("ee ff") == 0)

  }

  test("romperCesar: recupera una frase cifrada con 5") {

    assert(romperCesar(cesar("este es un mensaje secreto de prueba", 5)) == "este es un mensaje secreto de prueba")

  }

  test("romperCesar: un mensaje sin letras no cambia") {

    assert(romperCesar("123") == "123")

  }

  test("romperCesar: se equivoca con fdvd, que venía de casa") {

    assert(romperCesar("fdvd") == "gewe")

  }

  // Punto 5: combinaciones

  test("combinaciones: 2 de largo con 3 letras dan 6") {

    assert(combinaciones(2, 3) == 6)

  }

  test("combinaciones: 4 de largo con 3 letras dan 24") {

    assert(combinaciones(4, 3) == 24)

  }

  test("combinaciones: largo 0 da 1") {

    assert(combinaciones(0, 5) == 1)

  }

  test("combinaciones: largo 1 con 10 letras da 10") {

    assert(combinaciones(1, 10) == 10)

  }

  test("combinaciones: 3 de largo con 10 letras dan 810") {

    assert(combinaciones(3, 10) == 810)

  }

  // Punto 5: vigenere

  test("vigenere: abc con la clave bcd da bdf") {

    assert(vigenere("abc", "bcd") == "bdf")

  }

  test("vigenere: zzz con la clave abc da zab") {

    assert(vigenere("zzz", "abc") == "zab")

  }

  test("vigenere: el dígito no gasta letra de la clave") {

    assert(vigenere("a1b", "bc") == "b1d")

  }

  test("vigenere: la clave se repite cuando se acaba") {

    assert(vigenere("ab cd", "xyz") == "xz ba")

  }

  test("vigenere: un mensaje vacío sale vacío") {

    assert(vigenere("", "sol") == "")
    
  }
}