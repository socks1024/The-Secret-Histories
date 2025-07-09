package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Grail;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class InfluenceGrail extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceGrail.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = GRAIL;

    public InfluenceGrail() {
        super(ID, PRINCIPLE_TAG);
    }
}
