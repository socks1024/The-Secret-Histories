package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Moth;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.MOTH;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class InfluenceMoth extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceMoth.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = MOTH;

    public InfluenceMoth() {
        super(ID, PRINCIPLE_TAG);
    }
}
