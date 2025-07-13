package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Edge;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.EDGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class InfluenceEdge extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceEdge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = EDGE;

    public InfluenceEdge() {
        super(ID, PRINCIPLE_TAG);
    }
}
