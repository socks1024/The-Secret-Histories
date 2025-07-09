package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Grail;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class InfluenceGrail extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceGrail.class.getSimpleName());

    public InfluenceGrail() {
        super(ID, GRAIL);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple(abstractPlayer, new Grail(abstractPlayer, this.principleCount));
    }
}
