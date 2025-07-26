package TheSecretHistories.Content.Cards.FITIF.Fragments;

import TheSecretHistories.Content.Powers.Principles.Winter;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class FragmentWinter extends AbstractFragment{

    public static String ID = StringUtils.MakeID(FragmentWinter.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = WINTER;

    public FragmentWinter() {
        super(ID, PRINCIPLE_TAG, CardTarget.ENEMY);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractMonster, abstractPlayer, new Winter(abstractMonster, principleCount)));
    }
}
