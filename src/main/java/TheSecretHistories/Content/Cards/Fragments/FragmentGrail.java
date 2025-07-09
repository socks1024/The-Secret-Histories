package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Grail;
import TheSecretHistories.Content.Powers.Principles.Heart;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;

public class FragmentGrail extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentGrail.class.getSimpleName());

    public FragmentGrail() {
        super(ID, LANTERN);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        GainPrinciple(abstractPlayer, new Grail(abstractPlayer, magicNumber));
    }
}
