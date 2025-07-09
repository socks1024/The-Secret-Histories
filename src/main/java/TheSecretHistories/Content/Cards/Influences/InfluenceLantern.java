package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class InfluenceLantern extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceLantern.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = LANTERN;

    public InfluenceLantern() {
        super(ID, PRINCIPLE_TAG);
    }
}
