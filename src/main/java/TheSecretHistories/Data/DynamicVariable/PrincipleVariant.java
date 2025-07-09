package TheSecretHistories.Data.DynamicVariable;


import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class PrincipleVariant extends DynamicVariable {

    @Override
    public String key() {
        return "P";
    }

    @Override
    public boolean isModified(AbstractCard abstractCard) {
        TemplateCustomCard tCard = (TemplateCustomCard)abstractCard;
        return tCard.principleCount != tCard.basePrincipleCount;
    }

    @Override
    public int value(AbstractCard abstractCard) {
        TemplateCustomCard tCard = (TemplateCustomCard)abstractCard;
        return tCard.principleCount;
    }

    @Override
    public int baseValue(AbstractCard abstractCard) {
        TemplateCustomCard tCard = (TemplateCustomCard)abstractCard;
        return tCard.basePrincipleCount;
    }

    @Override
    public boolean upgraded(AbstractCard abstractCard) {
        TemplateCustomCard tCard = (TemplateCustomCard)abstractCard;
        return tCard.upgradedPrincipleCount;
    }
}
