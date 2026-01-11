package ai.acyclic.six.spark.spike

import ai.acyclic.six.spark.SparkEnvSpec

class ErrorDemo extends SparkEnvSpec {

  ignore("runtime error") {

    sys.error("runtime!")
  }

//  { // compile time error
//    val v: String = 1.2
//  }

  it("diff error") {

    val ll =
      """
        |one
      |two
      |three
        |""".stripMargin

    val rr =
      """
        |one
        |2
        |3
        |""".stripMargin

    assert(ll === rr)
  }
}
