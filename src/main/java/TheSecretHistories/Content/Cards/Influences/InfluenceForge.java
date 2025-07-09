package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Forge;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRET_HISTORIES;

public class InfluenceForge extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceForge.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = FORGE;

    public InfluenceForge() {
        super(ID, PRINCIPLE_TAG);
    }
}
