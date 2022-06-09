package com.ats.atsbookmyshow

import com.ats.atsbookmyshow.domain.Employee
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import reactor.core.publisher.Flux


@SpringBootApplication
@EnableNeo4jRepositories
@EnableReactiveMongoRepositories
@OpenAPIDefinition(info = Info(title = "Ecom APis", version = "3.0.3", description = "Documentation APIs v3.0.3"))
class EcomApplication

var <T> List<T>.lengooth: Int
  get() = size
	set(value) {}

fun main(args: Array<String>) {
	runApplication<EcomApplication>(*args)
	var s: String? = "abcd"
	s = null

	println(s?.length ?: -1)
	println(mutableListOf(1, 4, 5, 6, 7, 8).takeWhile { it.rem(4)==0 })
}

fun program2() {
	val square: (Int) -> Int = { x -> x * x}
	println(square(3))
	//program1()
	val list = listOf("sk", "ramu", "Amit")

	//println(list.findByCondition { it == "ramu" })
	println(list.lengooth)
}

fun program1() {
	println("Karmakar".groupingBy { it.lowercaseChar() }.eachCount())
	val finalList = listOf("Souptik", "Amit", "Albam", "Jeelani", null)
						.filter { null!=it && !it.startsWith("A") }
	println(finalList)

	val empList = listOf(Employee("Aaron", listOf("Cricket", "Football")),
		Employee("David", listOf("Cricket")),
		Employee("Steve", listOf("Football")))
}

fun <T> List<T>.findByCondition(func: (T) -> Boolean): Boolean {

	for (e in this) {
		if (func(e)) {
			return true
		}
	}
	return false
}