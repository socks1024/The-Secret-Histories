package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Knock;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class InfluenceKnock extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceKnock.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = KNOCK;

    public InfluenceKnock() {
        super(ID, PRINCIPLE_TAG);
    }
}
