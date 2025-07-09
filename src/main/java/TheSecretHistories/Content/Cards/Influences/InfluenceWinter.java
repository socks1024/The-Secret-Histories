package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class InfluenceWinter extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceWinter.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = WINTER;

    public InfluenceWinter() {
        super(ID, PRINCIPLE_TAG);
    }
}
