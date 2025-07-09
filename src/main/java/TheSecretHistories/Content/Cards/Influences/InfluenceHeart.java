package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Heart;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class InfluenceHeart extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceHeart.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = HEART;

    public InfluenceHeart() {
        super(ID, PRINCIPLE_TAG);
    }
}
