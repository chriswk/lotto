package com.chriswk.lotto
import scala.collection.SortedSet

object Lotto {
	def findWinners(correct : SortedSet[Int], extraNumbers : SortedSet[Int], myNumbers : List[SortedSet[Int]]): Unit = {
		println("Vinnerrekken: [" + correct.mkString(", ") +"]")
		println("Med tilleggstall [" + extraNumbers.mkString(", ") +"]")
		myNumbers.foreach((myLine : SortedSet[Int]) => {
			var correctNumbers : SortedSet[Int] = correct & myLine
			var extras : SortedSet[Int] = extraNumbers & myLine
			val intro = "Din rekke: [" + myLine.mkString(", ") +"] ga"
			val correctN = "deg (" +correctNumbers.size + ") rette [" +correctNumbers.mkString(", ") + "]"
			val extrasN = "og " + " (" +extras.size +") tilleggstall [" +extras.mkString(", ") +"]"
			println(intro)
			println(correctN)
			println(extrasN)
		})
	}
	
	def main(args : Array[String]) {
		var range : Int = args.first.toInt
		val correctArray = Console.readLine("Tast inn vinnerrekke\n").split(",")
		var correct:SortedSet[Int] = SortedSet()
		for(number <- correctArray) {
			correct += number.toInt
		}
		val extrasArray = Console.readLine("Tast inn tilleggs tall\n").split(",")
		var extras:SortedSet[Int] = SortedSet()
		for(number <- extrasArray) {
			extras += number.toInt
		}
		
		var myNumbers : List[SortedSet[Int]] = List()
		for(i <- 0 until range) {
			var myArray = Console.readLine("Tast inn din rekke\n").split(",")
			var my : SortedSet[Int] = SortedSet()
			for(number <- myArray) {
				my += number.toInt
			}
			myNumbers ::= my
		}
		findWinners(correct, extras, myNumbers)
	}
}