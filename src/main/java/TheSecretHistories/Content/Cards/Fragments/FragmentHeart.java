package TheSecretHistories.Content.Cards.Fragments;

import TheSecretHistories.Content.Powers.Principles.Heart;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class FragmentHeart extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentHeart.class.getSimpleName());

    public FragmentHeart() {
        super(ID, HEART);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        PlayerGainPrinciple(abstractPlayer, new Heart(abstractPlayer, this.principleCount));
    }
}
