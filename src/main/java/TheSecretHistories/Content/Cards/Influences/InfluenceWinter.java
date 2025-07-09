package TheSecretHistories.Content.Cards.Influences;

import TheSecretHistories.Content.Cards.Fragments.AbstractFragment;
import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class InfluenceWinter extends AbstractFragment {

    public static String ID = StringUtils.MakeID(InfluenceWinter.class.getSimpleName());

    public InfluenceWinter() {
        super(ID, WINTER);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple(abstractPlayer, new Winter(abstractPlayer, this.principleCount));
    }
}
