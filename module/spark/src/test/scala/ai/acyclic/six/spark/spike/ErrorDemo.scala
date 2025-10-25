package ai.acyclic.six.spark.spike

import ai.acyclic.six.spark.SparkEnvSpec

class ErrorDemo extends SparkEnvSpec {

  it("runtime error") {

    sys.error("runtime!")
  }

//  { // compile time error
//    val v: String = 1.2
//  }
}
