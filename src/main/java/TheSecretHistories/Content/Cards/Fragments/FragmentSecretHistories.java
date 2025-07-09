package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Knock;
import TheSecretHistories.Content.Powers.Principles.SecretHistories;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.LANTERN;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.SECRETHISTORY;

public class FragmentSecretHistories extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentSecretHistories.class.getSimpleName());

    public FragmentSecretHistories() {
        super(ID, SECRETHISTORY);

        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        GainPrinciple(abstractPlayer, new SecretHistories(abstractPlayer, magicNumber));
    }
}
