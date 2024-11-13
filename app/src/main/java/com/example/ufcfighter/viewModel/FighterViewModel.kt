import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.ufcfighter.model.Fighter
import com.example.ufcfighter.R  // Ensure R is imported for access to drawable resources

class FighterViewModel : ViewModel() {
    private val _fighters = mutableStateListOf(
        Fighter(1, "Tony Ferguson", R.drawable.tony_ferguson, "Known for his unique and unorthodox style."),
        Fighter(2, "Khabib Nurmagomedov", R.drawable.khabib_nurmagomedov, "Retired Russian fighter."),
        Fighter(3, "Israel Adesanya", R.drawable.israel_adesanya, "Nigerian-born New Zealand fighter."),
        Fighter(4, "Jon Jones", R.drawable.jon_jones, "American fighter with powerful grappling."),
        Fighter(5, "Dustin Poirier", R.drawable.dustin_poirier, "American lightweight contender."),
        Fighter(6, "Conor McGregor", R.drawable.mcgregor, "Irish professional fighter."),
        Fighter(7, "Stipe Miocic", R.drawable.stipe_miocic, "Former UFC heavyweight champion."),
        Fighter(8, "Illia Topuria", R.drawable.illia_topuria, "new era of fighter"),
        Fighter(9, "Max Holloway", R.drawable.max_holloway, "Former featherweight champion from Hawaii."),
        Fighter(10, "Jorge Masvidal", R.drawable.jorge_masvidal, "Known for his striking and fast knockouts.")
    )
    val fighters: SnapshotStateList<Fighter> = _fighters

 //untuk searcnya
    fun searchFighters(query: String): List<Fighter> {
        return if (query.isEmpty()) {
            _fighters
        } else {
            _fighters.filter { it.name.contains(query, ignoreCase = true) }
        }
    }
}
