package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Forge;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.FORGE;

public class FragmentForge extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentForge.class.getSimpleName());

    public FragmentForge() {
        super(ID, FORGE);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple(abstractPlayer, new Forge(abstractPlayer, this.principleCount));
    }
}
