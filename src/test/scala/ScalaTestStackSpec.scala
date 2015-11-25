import collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class StackSpec extends FlatSpec {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
  }

  it should "not throw an NoSuchElementException" in {
    val emptyStack = new Stack[String]
    //emptyStack.pop()
  }
}
