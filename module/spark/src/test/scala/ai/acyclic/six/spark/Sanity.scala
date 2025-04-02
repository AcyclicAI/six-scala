package ai.acyclic.six.spark

class Sanity extends SparkEnvSpec {

  it("simple") {

    val r = this.sc
      .parallelize(1 to 100)
      .map(v => v * v)
      .reduce(_ + _)

    assert(r == 338350)

  }

}
