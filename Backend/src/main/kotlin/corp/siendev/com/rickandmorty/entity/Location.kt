package corp.siendev.com.rickandmorty.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotNull

@Entity
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @NotNull
    val name: String,

    @NotNull
    val type: String,

    @NotNull
    val dimension: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    val character: Character
)
