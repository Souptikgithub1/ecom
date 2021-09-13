package com.ats.atsbookmyshow

import com.ats.atsbookmyshow.domain.Employee
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import java.util.stream.Collectors


@SpringBootApplication
@EnableNeo4jRepositories
@OpenAPIDefinition(info = Info(title = "Ecom APis", version = "3.0.3", description = "Documentation APIs v3.0.3"))
class EcomApplication

fun main(args: Array<String>) {
	runApplication<EcomApplication>(*args)
	program1()
}

fun program1() {
	println("Karmakar".groupingBy { it.toLowerCase() }.eachCount())
	val finalList = listOf("Souptik", "Amit", "Albam", "Jeelani", null)
						.filter { null!=it && !it.startsWith("A") }
	println(finalList)

	val empList = listOf(Employee("Aaron", listOf("Cricket", "Football")),
		Employee("David", listOf("Cricket")),
		Employee("Steve", listOf("Football")))
}
