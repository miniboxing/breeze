package breeze.linalg

import operators._
import support._
import breeze.math.MutableInnerProductSpace
import breeze.math.Semiring
import DenseMatrix._

/** Import this to provide access to a DenseMatrix[Double] as a MutableInnerProductSpace, so it can be used in optimization. */
object MutableInnerProductSpaceDenseMatrixDouble {


//	//implicit val canDotD_f = new CanDotDDenseMatrix[Float]
//	//implicit val canDotD_i = new CanDotDDenseMatrix[Int]

  implicit val space_d = {
    class CanDotDDenseMatrix extends BinaryOp[DenseMatrix[Double], DenseMatrix[Double], OpMulInner, Double] {
       override def apply(a: DenseMatrix[Double], b: DenseMatrix[Double]):Double = {
         require(a.rows == b.rows, "Vector row dimensions must match!")
         require(a.cols == b.cols, "Vector col dimensions must match!")
         val aVec = a.toDenseVector
         val bVec = b.toDenseVector
         aVec.dot(bVec)
       }
     }
    implicit val canDotD_d = new CanDotDDenseMatrix()

    //[error] /mnt/data-local/Work/Workspace/dev/breeze/math/src/main/scala/breeze/linalg/MutableInnerProductSpaceDenseMatrix.scala:27: could not find implicit value for parameter _dotVV: breeze.linalg.operators.BinaryOp[breeze.linalg.DenseMatrix[Double],breeze.linalg.DenseMatrix[Double],breeze.linalg.operators.OpMulInner,Double]
    //[error]     MutableInnerProductSpace.make[DenseMatrix[Double], Int, Double]
    //[error]                                  ^
    //[error] one error found
    //MutableInnerProductSpace.make[DenseMatrix[Double], Int, Double]
  }
}
