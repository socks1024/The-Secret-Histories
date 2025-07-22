package TheSecretHistories.Content.Cards.Others;


import TheSecretHistories.Content.Cards.FITIF.Followers.*;
import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;

public class Rumour extends TemplateCustomCard {

    public static final String ID = StringUtils.MakeID(Rumour.class.getSimpleName());

    private static final String IMG_NAME = "rumour";
    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.NONE;

    private static final AbstractCard[] FOLLOWERS = new AbstractCard[] {
        new FollowerLanternCat(),
        new FollowerLanternClifton(),
        new FollowerLanternSlee(),
        new FollowerForgeLaidlaw(),
        new FollowerForgeTristan(),
        new FollowerForgeValciane(),
        new FollowerEdgeElridge(),
        new FollowerEdgeRose(),
        new FollowerEdgeVictor(),
        new FollowerWinterAuclair(),
        new FollowerWinterViolet(),
        new FollowerHeartClovette(),
        new FollowerHeartDorothy(),
        new FollowerHeartLeo(),
        new FollowerGrailRenira(),
        new FollowerGrailSaliba(),
        new FollowerMothPorter(),
        new FollowerMothSylvia(),
        new FollowerMothYsabet(),
        new FollowerKnockEnid(),
        new FollowerKnockNeville(),
    };

    public Rumour() {
        super(ID, IMG_NAME, COST, TYPE, COLOR, RARITY, TARGET);

        this.exhaust = true;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.selfRetain = true;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {

        if (FOLLOWERS.length == 0) return;

        AbstractCard c = FOLLOWERS[new Random().nextInt(FOLLOWERS.length)];
        c.setCostForTurn(0);
        addToBot(new MakeTempCardInHandAction(c));
    }
}
