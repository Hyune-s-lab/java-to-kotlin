package travelator.tablereader

fun readTable(lines: List<String>): List<Map<String, String>> {
    return lines.map { parseLine(it) }
}

private fun parseLine(line: String): Map<String, String> {
    val values = line.split(",")
    val keys = values.indices.map { it.toString() }
    return keys.zip(values).toMap()
}
