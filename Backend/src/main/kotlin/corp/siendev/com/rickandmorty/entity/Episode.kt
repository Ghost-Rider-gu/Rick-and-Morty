package corp.siendev.com.rickandmorty.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.validation.constraints.NotNull

@Entity
data class Episode(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @NotNull
    val name: String,

    @NotNull
    val airDate: String,

    @NotNull
    val episode: String,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [
        CascadeType.PERSIST,
        CascadeType.MERGE,
        CascadeType.DETACH,
        CascadeType.REFRESH
    ])
    @JoinTable(name = "character_episode",
        joinColumns = [JoinColumn(name = "episode_id")],
        inverseJoinColumns = [JoinColumn(name = "character_id")]
    )
    val characters: List<Character>
)
