package TheSecretHistories.Content.Cards.Template;

import TheSecretHistories.Content.Actions.Principle.GainPrincipleAction;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;

import java.util.Objects;

public abstract class TemplateCustomCard extends CustomCard {

    protected CardStrings cardStrings;

    protected CardTags principleTag;

    public TemplateCustomCard(String id, String imgName, int cost, CardType type, CardColor color, CardRarity rarity, CardTarget target) {
        this(id, CardCrawlGame.languagePack.getCardStrings(id), imgName, cost, type, color, rarity, target);
    }

    public TemplateCustomCard(String id, CardStrings cardStrings, String imgName, int cost, CardType type, CardColor color, CardRarity rarity, CardTarget target) {
        this(id, cardStrings.NAME, imgName, cost, cardStrings.DESCRIPTION, type, color, rarity, target);

        this.cardStrings = cardStrings;
    }

    public TemplateCustomCard(String id, String name, String imgName, int cost, String description, CardType type, CardColor color, CardRarity rarity, CardTarget target){
        super(id, name, MakeCardImgPath(type, imgName), cost, description, type, color, rarity, target);
    }

    @Override
    public void upgrade() {
        if (!this.upgraded)
        {
            upgraded = true;
            UpgradeNameAndDescription();
            OnUpgrade(timesUpgraded);
        }
    }

    protected abstract void OnUpgrade(int timesUpgraded);

    protected void UpgradeNameAndDescription(){
        this.upgradeName();
        if (cardStrings.UPGRADE_DESCRIPTION != null & !Objects.equals(cardStrings.UPGRADE_DESCRIPTION, ""))
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        this.initializeDescription();
    }

    protected static String MakeCardImgPath(AbstractCard.CardType type, String img){
        String s1 = "TheSecretHistories/img/cards/";
        String s2 = "";
        switch (type){
            case ATTACK:s2 = "Attacks/";
                break;
            case SKILL:s2 = "Skills/";
                break;
            case POWER:s2 = "Powers/";
                break;
        }
        String s3 = img + ".png";

        return (s1+s2+s3);
    }

    protected void PlayerGainPrinciple(CardTags principleTag, int amount) {
        AbstractDungeon.actionManager.addToBottom(new GainPrincipleAction(AbstractDungeon.player, principleTag, amount));
    }

    protected void PlayerGainPrinciple() {
        PlayerGainPrinciple(principleTag, principleCount);
    }

    public int principleCount;

    public int basePrincipleCount;

    public boolean upgradedPrincipleCount = false;

    public void upgradePrincipleCount(int amount) {
        this.basePrincipleCount += amount;
        this.principleCount = basePrincipleCount;
        this.upgradedPrincipleCount = true;
    }

    public TemplateCustomCard DoUpgrade(int time) {
        for (int i = 0; i < time; i++) {
            upgrade();
        }

        return this;
    }

    public void OnObtain() {

    }
}
