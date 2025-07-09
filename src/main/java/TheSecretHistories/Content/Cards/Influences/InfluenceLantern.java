package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Lantern;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class InfluenceLantern extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceLantern.class.getSimpleName());

    public InfluenceLantern() {
        super(ID, LANTERN);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple(abstractPlayer, new Lantern(abstractPlayer, this.principleCount));
    }
}
