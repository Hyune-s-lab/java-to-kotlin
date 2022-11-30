package travelator

import java.util.*

class EmailAddress(
    private val localPart: String,
    private val domain: String
) {

    override fun equals(o: Any?): Boolean { // <5>
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as EmailAddress
        return localPart == that.localPart && domain == that.domain
    }

    override fun hashCode(): Int { // <5>
        return Objects.hash(localPart, domain)
    }

    override fun toString(): String { // <6>
        return "$localPart@$domain"
    }

    companion object {
        fun parse(value: String): EmailAddress { // <2>
            val atIndex = value.lastIndexOf('@')
            require(!(atIndex < 1 || atIndex == value.length - 1)) { "EmailAddress must be two parts separated by @" }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }
}
